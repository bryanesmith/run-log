resource "aws_s3_bucket" "staging-bucket" {
  bucket = var.staging_bucket_name
  acl    = "private"
  tags = var.common_tags
}
