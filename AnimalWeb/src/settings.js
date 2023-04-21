module.exports = {
  title: 'RECP小程序后台管理',

  baseConfig: {
    // vue模式: 通常前台用'history'模式，后台管理使用'hash'模式
    mode: 'hash',
    // 如果 真正部署时，部署路径存在项目名且 vue模式为 'history'，
    // 那这里projectName必须和部署的项目名一致，没有项目名为空字符串即可
    projectName: '',

    // 用来获取基本路径使用 (用在 'hash' 模式下)
    replaceUrl: 'backstage/index.html',
    // 打包时的基本配置，打包时改一下
    build: {
      publicPath: './',
      outputDir: '../ProdBuild/backstage',
      assetsDir: 'static'
    }
  }
}
