<template>
  <div id="detail">
    <navbar></navbar>
    <div class="wamp">
      <router-view></router-view>
    </div>
  </div>
</template>


<script>
var Navbar = require('_commons/layout/Navbar.vue')
//window.jQuery = require('jquery')// 给bootstrap用
require('bootstrap')
export default {
  name: 'detail',
  components: {
    Navbar
  }
}
</script>
