<template>
      <el-menu
          style="width: 200px;min-height: calc(100vh - 50px)"
          default-active="home"
          :default-openeds="[1]"
          class="el-menu-vertical-demo"
          router
      >
        <el-sub-menu index="1">
          <template #title>系统管理</template>
            <el-menu-item index="home" >用户管理</el-menu-item>
            <el-menu-item index="music" >音乐管理</el-menu-item>
        </el-sub-menu>

      </el-menu>
</template>