const lazyLoading = (resolve, name) => {
  require.ensure([], function(require) {
    resolve(require(`views/${name}.vue`));
  })
}
const CHANNEL = {

}
// 路由配置
var routes = [
   {
      path:'/index',
      name:'home',
      component: resolve => {
        lazyLoading(resolve,'home')
      },
      meta:{
        showName:"首页"
      },
      children:[
         {
              name: 'dDetail',
              path: 'dDetail',
              component: resolve => {
                lazyLoading(resolve, 'demond/dDetail')
              },
              meta: {
                showName: '点播课程详情',
              }
           },
      ]
    },
    {
      path:'/onDemand',
      name:'demand',
      component: resolve => {
        lazyLoading(resolve,'demand')
      },
      meta:{showName:'点播'}
    },
    {
      path:'/basic',
      name:'basic',
      component: resolve => {
        lazyLoading(resolve,'basic')
      },
      meta:{
        showName:"基础管理"
      },
      children:[
           {
              name: 'default',
              path: 'default',
              component: resolve => {
                lazyLoading(resolve, 'basic/context/default')
              },
              meta: {
                showName: '用户管理',
                expanded: false
              }
           },
           {
            name: 'component',
            path: 'component',
            component: resolve => {
              lazyLoading(resolve, 'basic/context/component')
            },
            meta: {
              showName: '年级管理',
              expanded: true
            },
          },
          {
              name: 'management',
              path: 'management',
              component: resolve => {
                lazyLoading(resolve, 'basic/context/management')
              },
              meta: {
                showName: '学科管理'
              }
          },{
            path:'/',
            redirect:"default"
          },
          {
              name: 'upload',
              path: 'upload',
              component: resolve => {
                lazyLoading(resolve, 'basic/context/upload')
              },
              meta: {
                showName: '上传资源管理',
              }
           },
            {
              name: 'source',
              path: 'source',
              component: resolve => {
                lazyLoading(resolve, 'basic/context/source')
              },
              meta: {
                showName: '录制资源管理',
              }
           },
           {
              name: 'comment',
              path: 'comment',
              component: resolve => {
                lazyLoading(resolve, 'basic/context/comment')
              },
              meta: {
                showName: '评论管理',
              }
           },
           {
              name: 'platform',
              path: 'platform',
              component: resolve => {
                lazyLoading(resolve, 'basic/context/platform')
              },
              meta: {
                showName: '平台配置',
              }
           },
            {
              name: 'server',
              path: 'server',
              component: resolve => {
                lazyLoading(resolve, 'basic/context/server')
              },
              meta: {
                showName: '服务器配置',
              }
           },
      ]
    },
    {
        path:'/mySubject',
        name:'mySubject',
        component: resolve => {
          lazyLoading(resolve,'mySubject')
        },
        meta:{showName:'我的课程'}
      },
];

module.exports = routes;
