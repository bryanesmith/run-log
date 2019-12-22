resource "aws_dynamodb_table" "run-log-dynamodb-table" {
  name = var.dynamodb_table
  read_capacity = 5
  write_capacity = 1
  hash_key = "@id"

  # Just specifying the key
  attribute {
    name = "@id"
    type = "S"
  }
}
