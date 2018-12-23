



# ファイルの保存

# Fragmentの使用
## FragmentとActivity間のデータのやり取り

- Fragment側でコールバックインターフェースをインナークラスとして定義し、Activity側で実装する
Fragment側に引数としてActivityに送りたいデータ型を指定したコールバックインターフェースを定義。
Activity側でインターフェースをオーバライドし、そのデータを用いた処理を行う。
- Fragmentのフィールドにコールバックインターフェースのインスタンスを作成
例の場合、
  
  public interface HogeListener{
    public void hoge(String str);
  }
  
  HogeListener listener;
  
- FragmentのonAttach()をオーバーライド
Activityがコールバックインターフェースを実装しているかを確認するとともに、フィールドのインターフェースインスタンスにActivityを代入す- 
  
