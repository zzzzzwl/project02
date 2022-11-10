<template>
  <div style="width: 100%; height: 100vh;background-color: skyblue;overflow: hidden">
    <div style=" width: 400px;margin: 150px auto">
      <div style="color: black; font-size: 30px;text-align: center;padding: 30px 0">欢迎登录</div>
      <el-form size="default" ref="form" :model="form">
        <el-form-item>
          <el-input prefix-icon="" v-model="form.userName" />
        </el-form-item>
        <el-form-item>
          <el-input prefix-icon="" v-model="form.password" show-password />
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%" type="primary">登 录</el-button>
        </el-form-item>
      </el-form>

    </div>
  </div>
</template>

<script>


export default {
  name: "Login",
  data(){
    return{
      form:{},
    }

  }
}
</script>

<style scoped>

</style>