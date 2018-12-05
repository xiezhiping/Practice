# 一个断点离线下载的java小项目
- [需求](\#需求)
- [架构](\#架构)

## 需求
1. UI
2. download
3. 断点续传
4. 多线程
5. save

## 架构
**我坚信：任何一个好的项目，架构是非常重要的，所以即使这是一个小项目，我也会抓住机会训练自己的架构意识，并不断优化**
由于项目不大，姑且分为三层。
* [PresentationLayer](\#PresentationLayer)
* [BusinessLayer](\#BusinessLayer)
* [DataLayer](\#DataLayer)

## PresentationLayer
展示层:包括下载UI，一些提示性的UI界面

## BusinessLayer
业务层：主要处理业务，同时为了解耦尽量明确，我将UI中的一些监听器从匿名内部内抽出来单独放在该业务层的包下面
## DataLayer
数据层:放一些数据对象对应的类