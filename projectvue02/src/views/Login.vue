<template>
  <div id="login">
    <div style="width: 100%; height: 100vh;overflow: hidden">
      <div style=" width: 400px;margin: 150px auto">
        <div style="color: black; font-size: 30px;text-align: center;padding: 30px 0">欢迎登录</div>
        <el-form size="default" ref="form" :model="form" :rules="rules">
          <el-form-item prop="userName">
            <el-input prefix-icon="user" v-model="form.userName" />
          </el-form-item>
          <el-form-item prop="password">
            <el-input prefix-icon="lock" v-model="form.password" show-password />
          </el-form-item>
          <el-form-item>
            <el-button style="width: 100%" type="primary" @click="login">登 录</el-button>
          </el-form-item>
          <el-form-item>
            <el-button type="text" @click="$router.push('/register')">前往注册 >> </el-button>
          </el-form-item>
        </el-form>

      </div>
    </div>
  </div>

</template>

<script>


import request from "@/utils/request";

export default {

  name: "Login",
  data(){
    return{
      form:{},
      rules:{
        userName:[
          {required:true,message:'请输入用户名',trigger:'blur'}

        ],
        password:[
          {required:true,message:"请输入密码",trigger:"blur"},
          { min: 6, max: 9, message: '密码应为6-9位', trigger: 'blur' },
        ]
      }
    }

  },
  methods:{
    login(){
      this.$refs['form'].validate((valid)=>{
        if (valid){
          request.post("/user/login",this.form).then(res=>{
            if (res.code==='0'){
              this.$message({
                type:"success",
                message:"登录成功"
              })
              sessionStorage.setItem("user", JSON.stringify(res.data))  // 缓存用户信息
              this.$router.push("/")
            }else {
              this.$message({
                type:"error",
                message:res.msg
              })
            }
          })

        }
      })

    }
  }
}

</script>

<style scoped>
#login {
  background: url("../assets/images/background.jpg") no-repeat center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}

</style>