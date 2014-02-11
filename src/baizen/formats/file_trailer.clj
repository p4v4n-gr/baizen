(ns baizen.formats.file-trailer
  (:require [baizen.formats :refer :all]
            [baizen.utils :refer [drop-slash]]))

(defrecord FileTrailer [line]
  BaiFormat
  (fields [_] [:record-code :file-control-total :number-of-groups :number-of-records])

  (prepare [this line]
    (-> line
        (assoc (index-of this :number-of-records) (drop-slash (get line (index-of this :number-of-records)))))))
