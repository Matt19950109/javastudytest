# アプリケーション名
楽しいjava

# アプリケーション概要
javaのGUIフレームワークswingを用いた問題解答ツール

# データベース設計

## userinfoテーブル
|Column|Type       |Options                        |
|------|-----------|-------------------------------|
|id    |varchar(20)|NOT NULL                       |
|pw    |varchar(20)|NOT NULL, DEFAULT 'weavus12345'|
|name  |varchar(20)|NOT NULL                       |
|auth  |int(4)     |NOT NULL, DEFAULT 1            |

## questionテーブル
|Column            |Type          |Options                       |
|------------------|-------------|-------------------------------|
|no                |int(4)       |NOT NULL                       |
|content           |varchar(2000)|NOT NULL                       |
|selection         |varchar(100) |NOT NULL                       |
|category          |int(2)       |NOT NULL                       |
|answer            |int(2)       |NOT NULL                       |
|participant_count |int(4)       |NOT NULL, DEFAULT 1            |
|correction_count  |int(4)       |NOT NULL, DEFAULT 1            |

## test_historyテーブル
|Column            |Type          |Options                       |
|------------------|-------------|-------------------------------|
|no                |int(4)       |NOT NULL                       |
|cate              |int(4)       |NOT NULL,FOREIGN KEY:TRUE      |
|user_id           |varchar(20)  |NOT NULL,FOREIGN KEY:TRUE      |
|sele              |int(2)       |NOT NULL                       |
|question_no       |int(4)       |NOT NULL,FOREIGN KEY:TRUE      |

## categoryテーブル
|Column            |Type         |Options                        |
|------------------|-------------|-------------------------------|
|id                |int(4)       |NOT NULL                       |
|title             |varchar(50)  |NOT NULL                       |


# 画面遷移図
[![Image from Gyazo](https://i.gyazo.com/02c82794352dcfd2aabc739c0ab59a3f.png)](https://gyazo.com/02c82794352dcfd2aabc739c0ab59a3f)

# これから実装予定
- 管理者権限に問題作成と編集を可能にする機能の付与
