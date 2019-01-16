import request from '@/utils/request'

export function getMenuList() {
  return request({
    url: '/system/menu/list',
    method: 'get'
  })
}

export function deleteMenu(params) {
  return request({
    url: '/system/menu/delete',
    method: 'post',
    data: params
  })
}

export function saveMenu(params) {
  return request({
    url: '/system/menu/save',
    method: 'post',
    data: params
  })
}

export function updateMenu(params) {
  return request({
    url: '/system/menu/update',
    method: 'post',
    data: params
  })
}

export function getUserList(params) {
  return request({
    url: '/user/list',
    method: 'post',
    data: params
  })
}

export function deleteUser(params) {
  return request({
    url: '/system/user/delete',
    method: 'post',
    data: params
  })
}

export function addUser(params) {
  return request({
    url: '/system/user/add',
    method: 'post',
    data: params
  })
}

export function updateUser(params) {
  return request({
    url: '/system/user/update',
    method: 'post',
    data: params
  })
}

export function updateUserRole(params) {
  return request({
    url: '/system/user/updateRole',
    method: 'post',
    data: params
  })
}

export function getUserRoles(params) {
  return request({
    url: '/system/user/roleList',
    method: 'get',
    params
  })
}

export function getRoleList() {
  return request({
    url: '/system/role/list',
    method: 'get'
  })
}
