# happy-oj

use IDEA plugin to dig into ojs

https://github.com/shuzijun/leetcode-editor 

* config
``` 
\happy-oj\leetcode-oj\src\main\java\club\tinysme\lsongseven\leetcode\oj
```
```
$!velocityTool.camelCaseName(${question.titleSlug})
```
```
  ${question.content}
  
  package club.tinysme.lsongseven.leetcode.oj.leetcode.editor.cn;
  public class $!velocityTool.camelCaseName(${question.titleSlug}){
      public static void main(String[] args) {
           Solution solution = new $!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
      }
      ${question.code}
  }
```