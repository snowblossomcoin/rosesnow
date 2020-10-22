## Data API

I think everything works


## Construction API

* /construct/preprocess -- provide list add addresses we need pub keys for

* /construction/metadata -- nothing

* /construction/payloads
  takes operations, pub keys, returns things to sign
  coins and operations to unsigned tx via signing payloads

* /construction/parse
  tx to operations

* /construction/combine
  signed payloads to complete tx

* /construction/hash

* /construction/submit


