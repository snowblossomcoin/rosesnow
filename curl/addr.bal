curl -d '{"network_identifier": {"blockchain":"snowblossom","network":"mainnet"}, "block_identifier":{"index":12}, "account_identifier":{"address":"snow:dk7traxesh3z3x27r5tp9qmmdrqjvv752fpc9anp"} }' -H "Content-Type: application/json" http://localhost:8080/account/balance | jq .

echo ""

