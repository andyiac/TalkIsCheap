
基于写的 demo 越来越多，还在使用Activity的方式对于我来说已经很浪费时间了。

所以有了这次重构，添加一个底部的导航栏，遵循 Google 新的设计。

这次重构的思路梳理如下：

原来的 MainActivity 和里边的内容不变，改成 OldMainActivity。

新建 NewMainActivity 里边采用 container 来显示 fragment。

NewMainActivity 是个GridView 每次都是手动添加（先添加xml 在写 onClick 方法 ）
一个包含 Title 和 content 的 Item。


BaseFragment 包含 Google 原生的返回键。


