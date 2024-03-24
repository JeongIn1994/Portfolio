# 1.概要

## 1.1 使用目的
#### 本サイトはPC,タブレット、モバイル環境から個人の開発履歴の記録、修正、削除、閲覧および
#### その開発中に発生した問題や得意事項などを記録、修正、削除、閲覧できる掲示板を重要機能を目的とする。

# 2.構成(ＰＣ画面基準）
## 2.1 初期画面

### ・ログオフの状態
![main_PC_NoLogin](https://github.com/JeongIn1994/Portfolio/assets/77004633/9dd738ed-6c69-4b26-a173-bf739d617e57)

### ・ログインの状態
![main_PC](https://github.com/JeongIn1994/Portfolio/assets/77004633/a2793fb7-9d6d-4d4c-aa2d-f25032e6454f)
#### ①管理者が登録した個人情報が表示される。
#### ②管理者が登録したスキルシートが表示される。
#### ③管理者が登録した履歴サマリが表示される。
#### ④ログイン情報を表示する。ログオフ状態の場合、ログインボタンが表示される。（・ログオフの状態参照）
#### ⑤管理者が登録した掲示物の最新の３個を表示する。
#### ⑥管理者が登録した履歴からスキルを通計し、多い順で３個まで表示する。

## 2.2 履歴画面


#### PowerShell
    $wsl
    $crontab -e
#### wsl
    0 0 * * * /bin/bash ~path/backup.sh
##### 上記のスクリプトは毎日０時０分に~path/backup.shパス上のスクリプトを自動的に実行。
##### 0 0 * * * に該当する部分は分、時、日、月曜、日順で、必要に合わせて書き直す。
##### 同じく ~path/ は必要に合わせてbackup.shがあるパスで書き直す。

## 1.2 FileUpload
### Upload Path 
#### default Path => C:/resourse/files/upload
#### application.properties 
    board.uploadUrl = C:/resources/files/upload
#### アップロードパスに合わせて書き直す。

## 1.3 Log
### Log Path
#### default Path = C:/resourse/files//log/logfile.log
#### logback-spring.xml
    <configuration>
    <!-- ログファイル置き場設定 -->
        <property name="LOG_FILE" value="C:/resources/files/log/logfile.log" />

        ....
#### アップロードパスに合わせて書き直す。
