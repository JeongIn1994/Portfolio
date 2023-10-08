# 1.initaillize

## 1.1 Bash Shell Script Auto Execute（ログ自動削除）
管理者モードでPowerShellを実行し、理科のコマンドを実行する。
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
