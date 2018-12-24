# TextFileOutput
## 概要
このアプリは、「はじめてのAndroid開発」Section9-1に対応したアプリです。
このアプリの作成を通して、ファイルの保存方法やAndroid　Studioにおけるバージョン管理を学んでいきます。

### 機能
### ファイルの保存

### Fragmentの使用
#### FragmentとActivity間のデータのやり取り

- Fragment側でコールバックインターフェースをインナークラスとして定義し、Activity側で実装する
Fragment側に引数としてActivityに送りたいデータ型を指定したコールバックインターフェースを定義。
Activity側でインターフェースをオーバライドし、そのデータを用いた処理を行う。
- Fragmentのフィールドにコールバックインターフェースのインスタンスを作成
例
~~~
  public interface HogeListener{
    public void hoge(String str);
  }
  
  HogeListener listener;
~~~
- FragmentのonAttach()をオーバーライド
Activityがコールバックインターフェースを実装しているかを確認するとともに、フィールドのインターフェースインスタンスにActivityを代入する
~~~
@Override
public void onAttach(){
  
