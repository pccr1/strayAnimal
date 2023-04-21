export function getApiBaseUrl() {
  if (process.env.NODE_ENV === 'development') {
    return process.env.VUE_APP_BASE_API
  } else {
    //正式部署的请求跟路径
    return 'http://whcb.jtexplorer.com'
  }
}

export function getFileBaseUrl() {
  return ''
}

