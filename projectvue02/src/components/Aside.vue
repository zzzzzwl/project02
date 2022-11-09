<template>
      <el-menu
          style="width: 200px;min-height: calc(100vh - 50px)"
          default-active="2"
          class="el-menu-vertical-demo"
      >
        <el-sub-menu index="1">
          <template #title>
            <el-icon><location /></el-icon>
            <span>选项1</span>
          </template>
            <el-menu-item index="1-1">选项1-1</el-menu-item>
            <el-menu-item index="1-2">选项1-2</el-menu-item>
            <el-menu-item index="1-3">选项1-3</el-menu-item>

        </el-sub-menu>

        <el-menu-item index="2">
          <el-icon><icon-menu /></el-icon>
          <span>选项2</span>
        </el-menu-item>


      </el-menu>
</template>