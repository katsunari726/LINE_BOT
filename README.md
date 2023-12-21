# ChatGPTを導入したLINE公式アカウント


LINE公式アカウント（BOT）からのWebhookをトリガーにAWS Lambda上で動作するプログラムです。  
ChatGPTの持つ自然言語処理技術を応用し、LINE公式アカウントを自然なチャットBOTに変化させます。


1. LINE BOTからのリクエスト内容を取得・整形
1. 整形したリクエスト内容をChatGPT APIに送信
1. ChatGPT APIから返却されたレスポンス内容を整形し、LINE BOTへ返却


※APIキーやアクセストークンはAWS上で管理しています。


## 構成

### 【使用言語】
* Java-17

### 【使用技術】
* AWS API Gateway
* AWS Lambda
* LINE Messaging API
* ChatGPT API


##  プロジェクトビルド
実行 > Mavenビルド... > ゴールに下記を設定  
* `package shade:shade`


## 【LINE公式アカウント】
[友だち追加](https://liff.line.me/1645278921-kWRPP32q/?accountId=790slrgb)


<img src="https://github.com/katsunari726/LINE_BOT/assets/154241712/77ee6583-f2a5-4d1d-9b75-de64142866e8" width="30%" /><br>


### 【イメージ】
<img src="https://github.com/katsunari726/LINE_BOT/assets/154241712/2a388614-e283-4f4c-b35b-4e56c65457b6" width="40%" />
