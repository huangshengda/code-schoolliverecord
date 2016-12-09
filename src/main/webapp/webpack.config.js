var webpack = require('webpack')
var path = require('path')
var autoprefixer = require('autoprefixer')
var precss = require('precss')
var HtmlWebpackPlugin = require('html-webpack-plugin')
var ExtractTextPlugin = require("extract-text-webpack-plugin")
// var ExtractTextPlugin = require("extract-text-webpack-plugin")

module.exports = {
	entry: {
		base: './entry/base.js',
		app: './pages/app.js',
		demond: './entry/demond.js',
		live: './entry/live.js'
	},
	output: {
		path: path.resolve(__dirname, './dist'),
		publicPath: './dist/',
		filename: 'slr_[name].js'
	},
    plugins: [
      /*new HtmlWebpackPlugin({
        title: 'my title',
        filename: 'index.html'
      }),*/
      new webpack.DefinePlugin({'process.env.NODE_ENV': '"development"'}),
      new webpack.HotModuleReplacementPlugin(),
      //new ExtractTextPlugin("basic.css"),
      new webpack.optimize.CommonsChunkPlugin({
            names: 'common',
            minChunks: 2
        }),
      new webpack.optimize.CommonsChunkPlugin({name:'manifest',chunks:'common'})
      /*new webpack.ProvidePlugin({
	      $: "jquery",
	      jquery: "jquery",
	      jQuery: "jquery",
	      "window.$": "jquery",
	      "window.jquery": "jquery",
	      "window.jQuery": "jquery"
	    })*/
  ],
  module: {
    loaders: [
      { test: /\.html$/, loader: "html-loader" },
      {
        test: /\.(jpe?g|png|gif|svg)$/i,
        loader: 'url?limit=10000'
      },
      {
        test: /\.(woff2?|eot|ttf|otf|svg)(\?.*)?$/,
        loader: 'url?limit=10000'
      },
      { 
        /*test: /\.css$/, loader: ExtractTextPlugin.extract('style-loader',"css-loader!postcss-loader") */
        test: /\.css$/,
        loader: "style!css"
      }, 
      {
        test: /\.js$/,
        exclude: /node_modules/,
        loader: 'babel-loader'
      },
      /*{
        test: require.resolve('jquery'),
        loader: 'expose?jQuery!expose?$'
      },*/
      {
        test: /\.vue$/,
        loader: 'vue',
        options: {
        }
      },
      {
        test: /\.json$/,
        loader: 'json-loader',
      }
    ]
  },
  postcss: function () {
    return [autoprefixer, precss]
  },
  // 让 vue-loader 支持 postcss。 http://vue-loader.vuejs.org/en/features/postcss.html
  vue: {
    //postcss: [autoprefixer(), precss()],
    //loaders: {
      // not work http://vue-loader.vuejs.org/en/configurations/extract-css.html
      // css: ExtractTextPlugin.extract("css")
      // sass: ExtractTextPlugin.extract("sass!less")
    //}
  },
  resolve: {
	  alias: {
	      'component': path.resolve(__dirname, './pages/_commons'),
	      'views': path.resolve(__dirname, './pages/views'),
	      'menu': path.resolve(__dirname, './pages/router/menu.js'),
	      'public': path.resolve(__dirname, './public')
	    }
  },
 
}