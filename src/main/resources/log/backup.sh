#!/bin/bash

BACKUP_DATE=$(date +'%Y/%m/%d')
LOG_FILE_NAME="logfile.log"
LOG_PATH=$(dirname "$0")/$LOG_FILE_NAME

echo "Update Log Date Is :$BACKUP_DATE"
echo "$BACKUP_DATE"

if [ ! -e $LOG_FILE_NAME ]; then 
	echo "ログファイルが存在しません。"
fi

if [ ! -d $BACKUP_DATE ]; then 
	echo "ディレクトリが存在しません。新しいバックアップディレクトリ作成します。"
	mkdir -p "$BACKUP_DATE"
fi

cp -f $LOG_PATH $BACKUP_DATE/$LOG_FILE_NAME

if [ $? eq 0 ]; then
	rm $LOG_PATH
else 
	echo "バックアップに失敗しました。"
fi
