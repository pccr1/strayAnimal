const getters = {
  sidebar: state => state.app.sidebar,
  size: state => state.app.size,
  device: state => state.app.device,
  visitedViews: state => state.tagsView.visitedViews,
  cachedViews: state => state.tagsView.cachedViews,
  routeTree: state => state.router.routeTree,
  routePathList: state => state.router.routePathList,
  userInfo: state => state.login.userInfo
}
export default getters
