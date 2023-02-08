<template>
  <div style="height: 100%;line-height: 50px;border-bottom: 1px solid #ccc;display: flex">
    <div style="margin: auto">
      <audio controls ref="audio">
        <source src=""/>
      </audio>
    </div>
  </div>
</template>

<script>
export default {
  name: "Bottom",
  data(){
    return{
      musicurl:''

    }
  },
  methods:{
    play1(){
      this.$refs.audio.src=this.musicurl
      this.$refs.audio.play();
    }
  },

}
</script>

<style scoped>

</style>