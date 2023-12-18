# LINE_BOT

LINE公式アカウント（BOT）からのWebhookをトリガーにAWS Lambda上で動作するプログラムです。  
ChatGPTの持つ自然言語処理技術を応用し、LINE公式アカウントを自然なチャットBOTに変化させます。

1. LINE BOTからのリクエスト内容を取得・整形
1. 整形したリクエスト内容をChatGPT APIに送信
1. ChatGPT APIから返却されたレスポンス内容を整形し、LINE BOTへ返却


## 構成

### 【使用言語】
* Java-17

### 【使用技術】
* AWS API Gateway
* AWS Lambda
* LINE Messaging API
* ChatGPT API

サンプル：[友だち追加はこちら](https://liff.line.me/1645278921-kWRPP32q/?accountId=790slrgb)
