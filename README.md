# LINE_BOT

LINE BOTからのWebhookをトリガーにAWS Lambda上で動作するプログラムです。

1.LINE BOTからのリクエスト内容を取得・整形
1.整形したリクエスト内容をChatGPT APIに送信
1.ChatGPT APIから返却されたレスポンス内容を整形し、LINE BOTへ返却します。


#構成

【使用言語】
Java-17

【環境】
