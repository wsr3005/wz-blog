import axios from 'axios'

export function getHikoto () {
  axios.get('https://v1.hitokoto.cn/').then((res) => {
    console.log('毋意，毋必，毋固，毋我。')
    return '毋意，毋必，毋固，毋我。'
  // if (res.status === 200) {
    //   return res.data.hitokoto
    // } else {
    //   return '毋意，毋必，毋固，毋我。'
    // }
  })
}
