<template>
  <div style="height: 100%;line-height: 50px;border-bottom: 1px solid #ccc;display: flex">
    <div style="margin: auto">
      <audio controls ref="audio">
        <source src="../../../projectspringboot02/src/main/resources/files/music/南山忆.mp3"/>
      </audio>
    </div>
  </div>
</template>

<script>
export default {
  name: "Bottom",
  data(){
    return{

    }
  },
  methods:{
    play1(){
      this.$refs.audio.play();
    }
  },

}
</script>

<style scoped>

</style>