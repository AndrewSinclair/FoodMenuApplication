(use ['food-app.database :only [connect-db wrap-transaction]])

(defn gen-item [title body]
  (db/transaction
   (str "INSERT INTO menu VALUES (" title ", " body "))))

(connect-db)

(gen-item "cake"    "it's delicious")
(gen-item "pudding" "it's very good")
