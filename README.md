# initaillize

##Bash Shell Script Auto Execute
####PowerShell
    $wsl
    crontab -e
####wsl
    0 0 * * * /bin/bash ~path/backup.sh
###위 스크립트는 매일 0시 0분에 ~path/backup.sh 경로상의 스크립트를 자동으로 실행시켜주는 cron
###0 0 * * * 에 해당하는 부분은 분 시 일 월 요일순으로 각자 필요에 맞게 수정 
