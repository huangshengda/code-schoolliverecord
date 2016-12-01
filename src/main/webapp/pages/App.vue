<template>
  <div id="app">
    <navbar></navbar>
    <div class="wamp">
         <router-view></router-view>
    </div>
    <div>
    </div>
  </div>
</template>


<script>
var Navbar = require('./_commons/layout/Navbar.vue')
/*var Footer = require('./_commons/layout/footer.vue')*/
export default {
  name: 'app',
  components: {
    Navbar,
  }
}
</script>
