# 0.システム仕様
### バックエンド
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white) 
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

### フロントエンド
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![jQuery](https://img.shields.io/badge/jquery-%230769AD.svg?style=for-the-badge&logo=jquery&logoColor=white)

### OS
![Windows 11](https://img.shields.io/badge/Windows%2011-%230079d5.svg?style=for-the-badge&logo=Windows%2011&logoColor=white)
![Linux](https://img.shields.io/badge/Linux-FCC624?style=for-the-badge&logo=linux&logoColor=black)
# 1.概要

## 1.1 使用目的
#### 本ウェブアプリケーションはPC,タブレット、モバイル環境から個人の開発履歴の記録、修正、削除、閲覧および
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
#### ⑥管理者が登録した過去１年間の履歴からスキルを通計し、多い順で３個まで表示する。

## 2.2 履歴画面

### ・ログオフの状態
![history_PC](https://github.com/JeongIn1994/Portfolio/assets/77004633/027d5a31-fdbc-4e2b-ac8b-d9c4fb064f1b)

### ・ログインの状態
![history_PC_NoLogin](https://github.com/JeongIn1994/Portfolio/assets/77004633/3455ad39-c324-4ab5-b88b-771c77fa175b)

#### ①管理者権限がある場合表示される履歴登録ボタンを表しする。
#### ②各履歴の詳細を確認するためのボタンを表示する。

### 2.2.1 履歴閲覧
![History_PC_Read](https://github.com/JeongIn1994/Portfolio/assets/77004633/2dc1519c-2992-4f87-b652-696837a074fe)

#### ①プロジェクトのタイトルを表示する。
#### ②開発言語を表示する。　
#### ③プロジェクトのサマリを表示する。
#### ④プロジェクトの詳細を表示する。
#### ⑤プロジェクトの進捗を表示する。
#### ⑦開発履歴リスト画面に戻るボタンを表示する。
#### ⑧管理者権限がある場合、街道履歴の修正画面に移動するボタンを表示する。

### 2.2.2 履歴作成
![History_PC_Create](https://github.com/JeongIn1994/Portfolio/assets/77004633/bf5d44b2-4b20-4fdf-9bda-47bf19e1658b)

#### ①プロジェクトのタイトル入力欄を表示する。
#### ②開発言語選択コンボボックスを表示する。　
#### ③プロジェクトのサマリ登録ボタンを表示する。
#### ④プロジェクトのサマリの削除ボタンを表示する。
#### ⑤プロジェクトの詳細フォームを表示する。
#### ⑦開発開始日入力フォームを表示する。
#### ⑦開発終了日入力フォームを表示する。
#### ⑦開発履歴リスト画面に戻るボタンを表示する。
#### ⑧管理者権限がある場合、履歴登録機能を行うボタンを表示する。

### 2.2.3 履歴修正
![History_PC_Update](https://github.com/JeongIn1994/Portfolio/assets/77004633/9d06d006-83f0-4b38-81a3-b465e1156137)

#### ①プロジェクトのタイトル入力欄を表示する。
#### ②開発言語選択コンボボックスを表示する。
#### ③登録したプロジェクトのサマリ登録ボタンを表示する。
#### ④プロジェクトのサマリ登録ボタンを表示する。
#### ⑤プロジェクトのサマリの削除ボタンを表示する。
#### ⑥プロジェクトの詳細フォームを表示する。
#### ⑦登録した開発開始日入力フォームを表示する。
#### ⑧登録した開発終了日入力フォームを表示する。
#### ⑨開発履歴リスト画面に戻るボタンを表示する。
#### ⑩管理者権限がある場合、履歴更新機能を行うボタンを表示する。
#### ⑪管理者権限がある場合、履歴削除機能を行うボタンを表示する。



