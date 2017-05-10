<template>
  <div class="layout">
    <Row>
      <Col span="8">&nbsp;</Col>
      <Col span="8">
        <Form :label-width="100" :rules="validate" ref="addForm" :model="object">
          <Form-item label="菜谱名称" prop="name" required>
            <Input size="large" v-model="object.name" placeholder="请输入菜谱名称" style="width: 400px"></Input>
          </Form-item>
          <Form-item label="菜谱网址" prop="url" required>
            <Input size="large" v-model="object.url" placeholder="请输入菜谱网址" style="width: 400px"></Input>
          </Form-item>
          <Form-item size="large" label="菜谱类型" required>
            <Radio-group v-model="object.type" type="button">
              <Radio label="素菜">素菜</Radio>
              <Radio label="荤菜">荤菜</Radio>
              <Radio label="汤菜">汤菜</Radio>
              <Radio label="主食">主食</Radio>
              <Radio label="甜点">甜点</Radio>
            </Radio-group>
          </Form-item>
          <Form-item size="large" label="食用时间" required >
            <i-switch v-model="time1" size="large">
              <span slot="open">早餐可用</span>
              <span slot="close">早餐禁用</span>
            </i-switch>
            <i-switch v-model="time2" size="large">
              <span slot="open">午餐可用</span>
              <span slot="close">午餐禁用</span>
            </i-switch>
            <i-switch v-model="time3" size="large">
              <span slot="open">晚餐可用</span>
              <span slot="close">晚餐禁用</span>
            </i-switch>
            <i-switch v-model="time4" size="large">
              <span slot="open">宵夜可用</span>
              <span slot="close">宵夜禁用</span>
            </i-switch>
            <i-switch v-model="time5" size="large">
              <span slot="open">加餐可用</span>
              <span slot="close">加餐禁用</span>
            </i-switch>
          </Form-item>
          <Form-item size="large" label="食用季节" required >
            <i-switch v-model="season1" size="large">
              <span slot="open">春季可用</span>
              <span slot="close">春季禁用</span>
            </i-switch>
            <i-switch v-model="season2" size="large">
              <span slot="open">夏季可用</span>
              <span slot="close">夏季禁用</span>
            </i-switch>
            <i-switch v-model="season3" size="large">
              <span slot="open">秋季可用</span>
              <span slot="close">秋季禁用</span>
            </i-switch>
            <i-switch v-model="season4" size="large">
              <span slot="open">冬季可用</span>
              <span slot="close">冬季禁用</span>
            </i-switch>
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
        time1: true,
        time2: true,
        time3: true,
        time4: true,
        time5: true,
        time: '',
        word1: '',
        word2: '',
        word3: '',
        word4: '',
        word5: '',
        season1: true,
        season2: true,
        season3: true,
        season4: true,
        season: '',
        words1: '',
        words2: '',
        words3: '',
        words4: '',
        object: {
          name: '',
          url: '',
          type: '1'
        }
      }
    },
    computed: {
      time: function () {
        if (this.time1){
          this.word1 = '早'
        } else {
          this.word1 = ''
        }
        if (this.time2){
          this.word2 = '午'
        } else {
          this.word2 = ''
        }
        if (this.time3){
          this.word3 = '晚'
        } else {
          this.word3 = ''
        }
        if (this.time4){
          this.word4 = '夜'
        } else {
          this.word4 = ''
        }
        if (this.time5){
          this.word5 = '加'
        } else {
          this.word5 = ''
        }
        return this.word1 + this.word2 + this.word3 + this.word4 + this.word5
      },
      season: function () {
        if (this.season1){
          this.words1 = '春'
        } else {
          this.words1 = ''
        }
        if (this.season2){
          this.words2 = '夏'
        } else {
          this.words2 = ''
        }
        if (this.season3){
          this.words3 = '秋'
        } else {
          this.words3 = ''
        }
        if (this.season4){
          this.words4 = '冬'
        } else {
          this.words4 = ''
        }
        return this.words1 + this.words2 + this.words3 + this.words4
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
            time: this.time,
            season: this.season
          } },
          { headers: { 'X-Requested-With': 'XMLHttpRequest' } }
        ).then((response) => {
          if (response.body === 'OK') {
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
