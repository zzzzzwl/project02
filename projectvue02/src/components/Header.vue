<template>
  <div style="height: 50px;line-height: 50px;border-bottom: 1px solid #ccc;display: flex">
    <div style="width: 200px;padding-left: 30px;font-weight: bold;color: skyblue">Vae+</div>
    <div style="flex: 1"></div>
    <div style="width: 100px">
      <el-dropdown>
        <span class="el-dropdown-link" style="line-height: 50px">
          {{ user.userName }}<el-icon class="el-icon-arrow-right el-icon--right"><arrow-down /></el-icon>
        </span>
        <template #dropdown>
          <el-dropdown-menu>

            <el-dropdown-item>
              个人信息</el-dropdown-item>
            <el-dropdown-item @click="exit">退出</el-dropdown-item>

          </el-dropdown-menu>
        </template>
      </el-dropdown>

    </div>
  </div>
</template>

<script>
import {ArrowDown} from '@element-plus/icons-vue'
export default {
  name: "Header",
  props:['user'],
  components:{
    ArrowDown
  },
  methods:{
    exit(){
      sessionStorage.removeItem('user')
      this.$router.push('/login')

    }
  }

}
</script>

<style>

</style>