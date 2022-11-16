<template>
  <div style="width: 100%; height: 100vh;background-color: skyblue;overflow: hidden">
    <div style=" width: 400px;margin: 150px auto">
      <div style="color: black; font-size: 30px;text-align: center;padding: 30px 0">欢迎注册</div>
      <el-form size="default" ref="form" :model="form" :rules="rules">
        <el-form-item prop="userName">
          <el-input prefix-icon="user" v-model="form.userName" />
        </el-form-item>
        <el-form-item prop="password">
          <el-input prefix-icon="lock" v-model="form.password" show-password />
        </el-form-item>
        <el-form-item prop="confirm">
          <el-input prefix-icon="lock" v-model="form.confirm" show-password />
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%" type="primary" @click="register">注册</el-button>
        </el-form-item>
      </el-form>

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
          {required:true,message:"请输入用户名",trigger:"blur"}

        ],
        password:[
          {required:true,message:"请输入密码",trigger:"blur"},
          { min: 6, max: 9, message: '密码应为6-9位', trigger: 'blur' },
        ],
        confirm:[
          {required:true,message:"请确认密码",trigger:"blur"},
          { min: 6, max: 9, message: '密码应为6-9位', trigger: 'blur' },
        ],
      }
    }

  },
  methods:{
    register(){

      this.$refs['form'].validate((valid)=>{
        if (valid){
          if (this.form.password!=this.form.confirm){
            this.$message({
              type:"error",
              message:"两次密码输入不一致"
            })
            return
          }
          request.post("/user/register",this.form).then(res=>{
            if (res.code==='0'){
              this.$message({
                type:"success",
                message:"注册成功"
              })
              this.$router.push("/login")
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

</style>