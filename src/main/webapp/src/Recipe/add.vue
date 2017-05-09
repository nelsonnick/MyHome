<template>
  <div class="layout">

    <Row>
      <Col span="8">&nbsp;</Col>
      <Col span="8">
        <Form :label-width="100" :rules="validate" ref="addForm" :model="object">
          <Form-item label="菜谱名称" prop="name" required>
            <Input size="large" v-model="object.name" placeholder="请输入菜谱名称" style="width: 400px"></Input>
          </Form-item>
          <Form-item label="菜谱网址" prop="name" required>
            <Input size="large" v-model="object.url" placeholder="请输入菜谱网址" style="width: 400px"></Input>
          </Form-item>

          <Form-item size="large" label="菜谱类型" required>
            <Radio-group v-model="object.type" type="button">
              <Radio label="1">素菜</Radio>
              <Radio label="2">荤菜</Radio>
              <Radio label="3">汤菜</Radio>
              <Radio label="4">主食</Radio>
              <Radio label="5">甜点</Radio>
            </Radio-group>
          </Form-item>
          <Form-item>
            <Button size="large" type="success" @click="goSave">保存</Button>
            <Button size="large" type="warning" style="margin-left: 8px" @click="goReset">重置</Button>
            <Button size="large" type="ghost" style="margin-left: 8px" @click="goBack">返回</Button>
          </Form-item>
        </Form>
      </Col>
      <Col span="8">&nbsp;</Col>
    </Row>
  </div>
</template>
<script>
  import * as API from './API.js'
  export default {
    name: 'add',
    data () {
      return {
        name: '',
        permission: [],
        menu: [],
        showLoad: true,
        object: {
          name: '',
          url: '',
          type: '1'
        }
      }
    },

    methods: {
      goReset () {
        this.$refs.addForm.resetFields()
        this.object.name = ''
        this.object.url = ''
        this.object.type = '1'
        this.object.state = '1'
      },
      goSave () {
        this.$Loading.start()
        this.$Message.info('正在进行保存操作，请稍后...')
        this.$http.get(
          API.save,
          { params: {
            name: this.object.name,
            url: this.object.url,
            type: this.object.type,
            state: this.object.state
          } },
          { headers: { 'X-Requested-With': 'XMLHttpRequest' } }
        ).then((response) => {
          if (response.body === 'illegal' || response.body.toString() === 'overdue') {
            this.$Loading.error()
            this.$Notice.error({
              title: '登录过期或非法操作!'
            })
            window.location.href = '../MainDesktop'
          } else if (response.body === 'OK') {
            this.$Loading.finish()
            this.$Notice.success({
              title: '操作完成!',
              desc: '菜谱：' + this.object.name + '已保存！'
            })
            setTimeout(() => { this.$router.push({ path: '/list' }) }, 1000)
          } else {
            this.$Loading.error()
            this.$Notice.error({
              title: response.body
            })
          }
        }, (response) => {
          this.$Loading.error()
          this.$Notice.error({
            title: '服务器内部错误!'
          })
        })
      },
      goBack () {
        this.$router.push({ path: '/list' })
      }
    }
  }
</script>
<style scoped>
  .layout{
    border: 1px solid #d7dde4;
    background: #f5f7f9;
  }
</style>
