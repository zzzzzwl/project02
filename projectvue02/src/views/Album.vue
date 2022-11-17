<template>
  <el-skeleton style="width: 240px" :body-style="{ padding: '0px', marginBottom: '1px' }">
    <template #template>
      <img  src="../assets/images/大千世界.jpg">
      <div style="padding: 14px">
        <el-skeleton-item variant="p" style="width: 50%" />
        <div
            style="
            display: flex;
            align-items: center;
            justify-items:center;
          "
        >
          <div style="padding: 14px">
            <span>大千世界</span>
            <div class="bottom card-header">
              <el-button text class="button">查看详情</el-button>
            </div>
          </div>

        </div>
      </div>
    </template>
  </el-skeleton>
</template>

<script>


export default {
  name: "Album",

}
</script>

<style scoped>

</style>