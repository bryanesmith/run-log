resource "aws_dynamodb_table" "run-log-dynamodb-table" {
  name = var.dynamodb_table

  hash_key = "@id"
  read_capacity = 5
  write_capacity = 1

  tags = var.common_tags

  # Specifying the key, but not other columns
  attribute {
    name = "@id"
    type = "S"
  }
}
