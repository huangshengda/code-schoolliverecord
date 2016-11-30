<template>
  <aside>
    <ul class="menu-list">
      <li class="menu-level1" v-for="(item,index) in menu" :class="{'has-chlidren': item.children && item.children.length, 'unfold': item.meta.expanded ,'active':!index}">
        <div @click="toggle(item)">
          <router-link :to="$route.matched[0].path + '/' + item.path" :class="{'is-active': isActive(item.path)}">{{item.meta.showName}}</router-link>
        </div>
        <expanding  v-if="item.children && item.children.length">
          <ul v-show="item.children" class="menu-level2">
            <li v-for="subItem in item.children">
             <router-link :to="$route.matched[0].path + '/' + item.path + '/'+ subItem.path">{{subItem.meta && subItem.meta.showName || subItem.name}}</router-link>
            </li>
          </ul>
        </expanding>
      </li>
    </ul>
  </aside>
</template>

<script>
import menu from 'menu'
import Expanding from '../Expanding.vue'
const filterRoute= function(menu, map){
   let filterdMap= menu.filter(item=>{ return item.path == map.path} )
   let value=filterdMap[0].children.filter(item => {return item.path !== '/'})
   return value
}
export default {
  data() {
    return {
      menu: filterRoute(menu,this.$route.matched[0]),
      subMenu: []
    }
  },
  components: {
    Expanding
  },
  methods: {
    shouldExpandMatchItem (route) {
      let matched = route.matched
      let lastMatched = matched[matched.length - 1]
      let parent = lastMatched.parent || lastMatched

      if (parent === lastMatched) {
        const p = this.findParentFromMenu(route)
        if (p) {
          parent = p
        }
      }

      if ('expanded' in parent.meta && parent !== lastMatched) {
        parent.meta.expanded = true
      }
    },
    toggle (item) {
      item.meta.expanded = !item.meta.expanded
    },
    findParentFromMenu (route) {
      const menu= filterRoute(menu,this.$route.matched[1])
      for (let i = 0, l = menu.length; i < l; i++) {
        const item = menu[i]
        const k = item.children && item.children.length
        if (k) {
          for (let j = 0; j < k; j++) {
            if (item.children[j].name === route.name) {
              return item
            }
          }
        }
      }
    },
    isActive(path) {
      let matched = this.$route.matched
      let lastMatched = matched[matched.length - 1]
      return lastMatched && path === lastMatched.path
    }
  },
  mounted () {
    let route = this.$route
    if (route.name) {
      this.isReady = true
      this.shouldExpandMatchItem(route)
    }
  },
  watch: {
    $route (route) {
      this.shouldExpandMatchItem(route)
    }
  }
}
</script>

<style scoped>
  .menu{
    position: fixed;
    z-index: 1;
    left: 0;
    top: 90px;
    bottom: 0;
    width: inherit;
    border-right: 1px solid #e7e7e7;
    background-color: #ddd;
    padding-top: 20px;
    ul{
      margin: 0;
      list-style: none;
    }
  }
  .menu-list{
    padding-left: 0;
    ul{
      padding-left: 0;
    }
    a{
      display: block;
      line-height: 2;
      color: #333;
      text-decoration: none;

    }
  }
  .menu-level1{
    height: 32px;
    line-height: 32px;
    margin-top:20px;
    
    & .is-active, .menu-level2 .router-link-active{
      background-color: #00d1b2;
      color: #fff !important;
    }
    &.has-chlidren{
      position: relative;
      &:after{
        content: '\e080';
        font-family: 'Glyphicons Halflings';
        position: absolute;
        top: 0;
        right: 10px;
        transition: transform .5s ease-in;
      }
      .menu-level2{
        display: none;
      }
      &.unfold{
        &:after{
          transform: rotate(90deg);
        }
        .menu-level2{
          display: block;
          padding-left: 40px;
          a{
            padding-left: 10px;
            margin-right: 10px;
          }
        }
      }
    }

  }
.menu-level1 a.router-link-active{
  background-color:#f0f0f0;
  color:#34a150;
}
.menu-level1:hover,.menu-level1:visited,.menu-level1:active{
  background-color: #f0f0f0;
  a{color:#34a150;}
}

</style>
