<template>
  <ol class="breadcrumb">
    <li v-for="(item, index) in list">
        <template v-if=" index !== list.length - 1">
          <router-link class="red" :to="item.path">{{item.meta && item.meta.showName || item.name}}</router-link>
        </template>
        <template v-else>
          {{item.meta && item.meta.showName || item.name}}
        </template>
    </li>
  </ol>
</template>
<script>
export default {
   props: {
    list: {
      default: []
    }
  }
}
</script>
<style>
 .breadcrumb{margin-bottom: 0;}
</style>
