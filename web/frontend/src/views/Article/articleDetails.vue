<template>
  <v-container id="articledetails">

    <v-row>
      <v-col cols="12">
        <v-img class="images rounded-lg" :src="require('@assets/images/3.jpg')" width="100%" height="auto"></v-img>
      </v-col>
    </v-row>

    <v-row>
      <v-col cols="12">
        <v-sheet rounded="lg">
          <h1 class="text-center pt-3 pb-3">{{ title }}</h1>
          <p class="pa-8" v-html="text"></p>
        </v-sheet>
      </v-col>
    </v-row>

    <v-row>
      <v-col cols="12">
        <v-sheet rounded="lg">
          <h3 class="pa-3">评论</h3>
        </v-sheet>
      </v-col>
    </v-row>

  </v-container>
</template>

<script>
export default {
  name: 'articleDetails',
  data: () => ({
    title: 'wyq真帅',
    text: '<div class="RichText ztext Post-RichText"><h2>前言</h2><p>组件是 vue.js最强大的功能之一，而组件实例的作用域是相互独立的，这就意味着不同组件之间的数据无法相互引用。一般来说，组件可以有以下几种关系：</p><p class="ztext-empty-paragraph"><br></p><figure data-size="normal"><noscript><img src="https://pic3.zhimg.com/v2-e2d891f9392855a88c755973ac9f1a82_b.jpg" data-caption="" data-size="normal" data-rawwidth="706" data-rawheight="564" class="origin_image zh-lightbox-thumb" width="706" data-original="https://pic3.zhimg.com/v2-e2d891f9392855a88c755973ac9f1a82_r.jpg"/></noscript><img src="https://pic3.zhimg.com/80/v2-e2d891f9392855a88c755973ac9f1a82_720w.jpg" data-caption="" data-size="normal" data-rawwidth="706" data-rawheight="564" class="origin_image zh-lightbox-thumb lazy" width="706" data-original="https://pic3.zhimg.com/v2-e2d891f9392855a88c755973ac9f1a82_r.jpg" data-actualsrc="https://pic3.zhimg.com/v2-e2d891f9392855a88c755973ac9f1a82_b.jpg" data-lazy-status="ok"></figure><p class="ztext-empty-paragraph"><br></p><p>如上图所示，A 和 B、B 和 C、B 和 D 都是父子关系，C 和 D 是兄弟关系，A 和 C 是隔代关系（可能隔多代）。</p><p>针对不同的使用场景，如何选择行之有效的通信方式？这是我们所要探讨的主题。本文总结了vue组件间通信的几种方式，如props、$emit/$on、vuex、$parent / $children、$attrs/$listeners和provide/inject，以通俗易懂的实例讲述这其中的差别及使用场景，希望对小伙伴有些许帮助。</p><p>本文的代码请猛戳github博客，纸上得来终觉浅，大家动手多敲敲代码！</p><h2>方法一、props/$emit</h2><p>父组件A通过props的方式向子组件B传递，B to A 通过在 B 组件中 $emit, A 组件中 v-on 的方式实现。</p><h2>1.父组件向子组件传值</h2><p>接下来我们通过一个例子，说明父组件如何向子组件传递值：在子组件Users.vue中如何获取父组件App.vue中的数据 users:["Henry","Bucky","Emily"]</p><div class="highlight"><pre><code class="language-text">//App.vue父组件\n' +
      '&lt;template&gt;\n' +
      '  &lt;div id="app"&gt;\n' +
      '    &lt;users v-bind:users="users"&gt;&lt;/users&gt;//前者自定义名称便于子组件调用，后者要传递数据名\n' +
      '  &lt;/div&gt;\n' +
      '&lt;/template&gt;\n' +
      '&lt;script&gt;\n' +
      'import Users from "./components/Users"\n' +
      'export default {\n' +
      '  name: \'App\',\n' +
      '  data(){\n' +
      '    return{\n' +
      '      users:["Henry","Bucky","Emily"]\n' +
      '    }\n' +
      '  },\n' +
      '  components:{\n' +
      '    "users":Users\n' +
      '  }\n' +
      '}\n' +
      '//users子组件\n' +
      '&lt;template&gt;\n' +
      '  &lt;div class="hello"&gt;\n' +
      '    &lt;ul&gt;\n' +
      '      &lt;li v-for="user in users"&gt;{{user}}&lt;/li&gt;//遍历传递过来的值，然后呈现到页面\n' +
      '    &lt;/ul&gt;\n' +
      '  &lt;/div&gt;\n' +
      '&lt;/template&gt;\n' +
      '&lt;script&gt;\n' +
      'export default {\n' +
      '  name: \'HelloWorld\',\n' +
      '  props:{\n' +
      '    users:{           //这个就是父组件中子标签自定义名字\n' +
      '      type:Array,\n' +
      '      required:true\n' +
      '    }\n' +
      '  }\n' +
      '}\n' +
      '&lt;/script&gt;</code></pre></div><p><b>总结：父组件通过props向下传递数据给子组件。注：组件中的数据共有三种形式：data、props、computed</b></p><h2>2.子组件向父组件传值（通过事件形式）</h2><p>接下来我们通过一个例子，说明子组件如何向父组件传递值：当我们点击“Vue.js Demo”后，子组件向父组件传递值，文字由原来的“传递的是一个值”变成“子向父组件传值”，实现子组件向父组件值的传递。</p><p class="ztext-empty-paragraph"><br></p><figure data-size="normal"><noscript><img src="https://pic3.zhimg.com/v2-17b00ee7c68fa9230255fec072ef0bd2_b.png" data-caption="" data-size="normal" data-rawwidth="1240" data-rawheight="150" class="origin_image zh-lightbox-thumb" width="1240" data-original="https://pic3.zhimg.com/v2-17b00ee7c68fa9230255fec072ef0bd2_r.jpg"/></noscript><img src="https://pic3.zhimg.com/80/v2-17b00ee7c68fa9230255fec072ef0bd2_720w.png" data-caption="" data-size="normal" data-rawwidth="1240" data-rawheight="150" class="origin_image zh-lightbox-thumb lazy" width="1240" data-original="https://pic3.zhimg.com/v2-17b00ee7c68fa9230255fec072ef0bd2_r.jpg" data-actualsrc="https://pic3.zhimg.com/v2-17b00ee7c68fa9230255fec072ef0bd2_b.png" data-lazy-status="ok"></figure><p class="ztext-empty-paragraph"><br></p><div class="highlight"><pre><code class="language-text">// 子组件\n' +
      '&lt;template&gt;\n' +
      '  &lt;header&gt;\n' +
      '    &lt;h1 @click="changeTitle"&gt;{{title}}&lt;/h1&gt;//绑定一个点击事件\n' +
      '  &lt;/header&gt;\n' +
      '&lt;/template&gt;\n' +
      '&lt;script&gt;\n' +
      'export default {\n' +
      '  name: \'app-header\',\n' +
      '  data() {\n' +
      '    return {\n' +
      '      title:"Vue.js Demo"\n' +
      '    }\n' +
      '  },\n' +
      '  methods:{\n' +
      '    changeTitle() {\n' +
      '      this.$emit("titleChanged","子向父组件传值");//自定义事件  传递值“子向父组件传值”\n' +
      '    }\n' +
      '  }\n' +
      '}\n' +
      '&lt;/script&gt;\n' +
      '// 父组件\n' +
      '&lt;template&gt;\n' +
      '  &lt;div id="app"&gt;\n' +
      '    &lt;app-header v-on:titleChanged="updateTitle" &gt;&lt;/app-header&gt;//与子组件titleChanged自定义事件保持一致\n' +
      '   // updateTitle($event)接受传递过来的文字\n' +
      '    &lt;h2&gt;{{title}}&lt;/h2&gt;\n' +
      '  &lt;/div&gt;\n' +
      '&lt;/template&gt;\n' +
      '&lt;script&gt;\n' +
      'import Header from "./components/Header"\n' +
      'export default {\n' +
      '  name: \'App\',\n' +
      '  data(){\n' +
      '    return{\n' +
      '      title:"传递的是一个值"\n' +
      '    }\n' +
      '  },\n' +
      '  methods:{\n' +
      '    updateTitle(e){   //声明这个函数\n' +
      '      this.title = e;\n' +
      '    }\n' +
      '  },\n' +
      '  components:{\n' +
      '   "app-header":Header,\n' +
      '  }\n' +
      '}\n' +
      '&lt;/script&gt;</code></pre></div><p><b>总结：子组件通过events给父组件发送消息，实际上就是子组件把自己的数据发送到父组件。</b></p><h2>方法二、$emit/$on</h2><p><b>这种方法通过一个空的Vue实例作为中央事件总线（事件中心），用它来触发事件和监听事件,巧妙而轻量地实现了任何组件间的通信，包括父子、兄弟、跨级</b>。当我们的项目比较大时，可以选择更好的状态管理解决方案vuex。</p><h2>1.具体实现方式：</h2><div class="highlight"><pre><code class="language-text">var Event=new Vue();\n' +
      '    Event.$emit(事件名,数据);\n' +
      '    Event.$on(事件名,data =&gt; {});</code></pre></div><h2>2.举个例子</h2><p>假设兄弟组件有三个，分别是A、B、C组件，C组件如何获取A或者B组件的数据</p><div class="highlight"><pre><code class="language-text">&lt;div id="itany"&gt;\n' +
      '    &lt;my-a&gt;&lt;/my-a&gt;\n' +
      '    &lt;my-b&gt;&lt;/my-b&gt;\n' +
      '    &lt;my-c&gt;&lt;/my-c&gt;\n' +
      '&lt;/div&gt;\n' +
      '&lt;template id="a"&gt;\n' +
      '  &lt;div&gt;\n' +
      '    &lt;h3&gt;A组件：{{name}}&lt;/h3&gt;\n' +
      '    &lt;button @click="send"&gt;将数据发送给C组件&lt;/button&gt;\n' +
      '  &lt;/div&gt;\n' +
      '&lt;/template&gt;\n' +
      '&lt;template id="b"&gt;\n' +
      '  &lt;div&gt;\n' +
      '    &lt;h3&gt;B组件：{{age}}&lt;/h3&gt;\n' +
      '    &lt;button @click="send"&gt;将数组发送给C组件&lt;/button&gt;\n' +
      '  &lt;/div&gt;\n' +
      '&lt;/template&gt;\n' +
      '&lt;template id="c"&gt;\n' +
      '  &lt;div&gt;\n' +
      '    &lt;h3&gt;C组件：{{name}}，{{age}}&lt;/h3&gt;\n' +
      '  &lt;/div&gt;\n' +
      '&lt;/template&gt;\n' +
      '&lt;script&gt;\n' +
      'var Event = new Vue();//定义一个空的Vue实例\n' +
      'var A = {\n' +
      '    template: \'#a\',\n' +
      '    data() {\n' +
      '      return {\n' +
      '        name: \'tom\'\n' +
      '      }\n' +
      '    },\n' +
      '    methods: {\n' +
      '      send() {\n' +
      '        Event.$emit(\'data-a\', this.name);\n' +
      '      }\n' +
      '    }\n' +
      '}\n' +
      'var B = {\n' +
      '    template: \'#b\',\n' +
      '    data() {\n' +
      '      return {\n' +
      '        age: 20\n' +
      '      }\n' +
      '    },\n' +
      '    methods: {\n' +
      '      send() {\n' +
      '        Event.$emit(\'data-b\', this.age);\n' +
      '      }\n' +
      '    }\n' +
      '}\n' +
      'var C = {\n' +
      '    template: \'#c\',\n' +
      '    data() {\n' +
      '      return {\n' +
      '        name: \'\',\n' +
      '        age: ""\n' +
      '      }\n' +
      '    },\n' +
      '    mounted() {//在模板编译完成后执行\n' +
      '     Event.$on(\'data-a\',name =&gt; {\n' +
      '         this.name = name;//箭头函数内部不会产生新的this，这边如果不用=&gt;,this指代Event\n' +
      '     })\n' +
      '     Event.$on(\'data-b\',age =&gt; {\n' +
      '         this.age = age;\n' +
      '     })\n' +
      '    }\n' +
      '}\n' +
      'var vm = new Vue({\n' +
      '    el: \'#itany\',\n' +
      '    components: {\n' +
      '      \'my-a\': A,\n' +
      '      \'my-b\': B,\n' +
      '      \'my-c\': C\n' +
      '    }\n' +
      '});    \n'

  })
}
</script>

<style scoped>

#articledetails {
  width: 1200px;
  margin: 0 auto;
}

.images {
  margin: 0 auto;
}
</style>
