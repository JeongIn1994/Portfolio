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

## 2.2 掲示板画面

### ・ログオフの状態
![Board_PC_NoLogin](https://github.com/JeongIn1994/Portfolio/assets/77004633/8b513215-2501-4831-87ef-7482d8eca638)

### ・ログインの状態
![Board_PC](https://github.com/JeongIn1994/Portfolio/assets/77004633/c20a22e0-04fa-46c8-a1e9-65d065750ee7)

#### ①掲示物の番号を表示する。
#### ②掲示物のタイトルを表示する。
#### ③掲示物の作成者を表示する。
#### ④掲示物の作成日や最終修正日を表示する。
#### ⑤権限がある場合、掲示物を作成ボタンを表示する。
#### ⑥掲示板の移動するボタンを表示する。

## 2.2.1 掲示閲覧板画面
### ・ログオフの状態

![Board_PC_Read_NoLogin](https://github.com/JeongIn1994/Portfolio/assets/77004633/19f770e3-169b-484e-95f2-34750e09b907)

#### ①掲示物のタイトルを表示する。
#### ②掲示物の作成者を表示する。
#### ③掲示物の詳細を表示する。
#### ④掲示物の作成日を表示する。
#### ⑤掲示物の修正日を表示する。
#### ⑥掲示物リスト画面に戻るボタンを表示する。
#### ⑦掲示物のコメント数を表示する。
#### ⑧掲示物のコメントを表示する。
#### ⑨掲示物のコメント入力欄を表示する。

### ・ログインの状態
![Board_PC_Read](https://github.com/JeongIn1994/Portfolio/assets/77004633/74bf42b1-1698-4c2a-b4d1-ab769f1df284)
#### ①掲示物のタイトルを表示する。
#### ②掲示物の作成者を表示する。
#### ③掲示物の詳細を表示する。
#### ④掲示物の作成日を表示する。
#### ⑤掲示物の修正日を表示する。
#### ⑥掲示物リスト画面に戻るボタンを表示する。
#### ⑦掲示物のコメント数を表示する。
#### ⑧掲示物のコメントを表示する。
#### ⑨権限がある場合、掲示物のコメント入力欄にユーザー名を表示する。
#### ⑩権限がある場合、掲示物のコメント入力欄に入力欄を表示する。
#### ⑪権限がある場合、掲示物のコメント登録ボタンを表示する。

## 2.2.2 掲示板作成画面

![Board_PC_Create](https://github.com/JeongIn1994/Portfolio/assets/77004633/bfba62de-cd0b-4a51-890f-5b93876ccac1)
#### ①掲示物のタイトル入力欄を表示する。
#### ②掲示物の作成者を表示する。
#### ③掲示物の詳細入力欄を表示する。
#### ④掲示物リストへ戻るを表示する。
#### ⑤掲示物作成ボタンを表示する。

## 2.2.3 掲示板修正画面

### ・ログインユーザーと作成者名が同じ場合の閲覧画面
![Board_PC_Read_SameUser](https://github.com/JeongIn1994/Portfolio/assets/77004633/ee283c8a-9d0e-4e35-aec3-23185b6ac287)
#### ①掲示物の修正ボタンを表示する。
#### ②掲示物の削除ボタンを表示する。

![Board_PC_Update](https://github.com/JeongIn1994/Portfolio/assets/77004633/cb6ecab0-ee84-41bb-81d8-5791f10deeed)
#### ①掲示物のタイトル入力欄を表示する。
#### ②掲示物の作成者を表示する。
#### ③掲示物の詳細入力欄を表示する。
#### ④掲示物リストへ戻るを表示する。
#### ⑤掲示物作成ボタンを表示する。

## 2.3 設定画面

![main_PC_Admin](https://github.com/JeongIn1994/Portfolio/assets/77004633/d0e66dc6-1bb7-4c9c-bf0a-0c385d521a40)
### ・ログインしたアカウントの権限が管理者権限の場合「Setting」メニューが表示される。

![main_PC_Setting](https://github.com/JeongIn1994/Portfolio/assets/77004633/c880000b-4a12-4e5d-a23e-7f82ed67a170)
####　①使用ユーザーの情報の確認、修正を行う画面を表示する。
####　②全ユーザーのメールアドレス、登録日、権限、アカウント状態を確認する画面を表示する。
####　③フロントエンドスキルシートを登録する画面を表示する。
####　④バックエンドスキルシートを登録する画面を表示する。
####　⑤ダイアログを閉じて初期画面に戻るボタンを表示する。

## 2.3.1 使用者情報画面

![main_PC_Setting_UserProfile](https://github.com/JeongIn1994/Portfolio/assets/77004633/e11e9d4f-5f9e-4811-bd24-47cf1bf2b500)

####　①使用ユーザーの名前入力欄を表示する。
####　②使用ユーザーのメールアドレスを表示する。
####　③使用ユーザーの住所入力欄を表示する。
####　④使用ユーザーの性別コンボボックスを表示する
####　⑤使用ユーザーの最終学校名入力欄を表示する。
####　⑥使用ユーザーの誕生日入力欄を表示する
####　⑦使用ユーザーの電話番号入力欄を表示する
####　⑧使用ユーザーの情報を更新するボタンを表示する。

## 2.3.2 ユーザー管理画面
![main_PC_Setting_UserManagementConsole](https://github.com/JeongIn1994/Portfolio/assets/77004633/0d052dfb-e695-46b9-88bd-8e37c83af641)

####　①ユーザーのメールアドレスを表示する。
####　②ユーザーの生成日を表示する。
####　③ユーザー名を表示する。
####　④ユーザーの権限を表示する
####　⑤ユーザーの権限の選択コンボボックスを表示する。
####　⑥ユーザーのアカウント状態を表示する
####　⑦ユーザーのアカウント状態の選択コンボボックスを表示する
####　⑧ユーザーの情報を更新するボタンを表示する。

## 2.3.3 使用者スキルシート（クライエントサイド）
![main_PC_Setting_FrontEnd](https://github.com/JeongIn1994/Portfolio/assets/77004633/0e840536-59ba-4443-877d-9c1220d2a17f)

####　①アップロードするスキルシートイメージを選択するボタンを表示する。
####　②アップロードするスキルシートイメージをアップロードするを表示する。
####　③選択するイメージを消すボタンを表示する。

## 2.3.4 使用者スキルシート（サーバーサイド）

![main_PC_Setting_BackEnd](https://github.com/JeongIn1994/Portfolio/assets/77004633/49430531-6eff-438e-bda9-449cadaee82e)
####　①アップロードするスキルシートイメージを選択するボタンを表示する。
####　②アップロードするスキルシートイメージをアップロードするを表示する。
####　③選択するイメージを消すボタンを表示する。
