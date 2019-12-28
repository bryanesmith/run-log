resource "aws_s3_bucket" "web-bucket" {
  bucket = var.s3_bucket_web
  acl    = "public-read"
  tags = var.common_tags

  policy = <<EOF
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "PublicReadGetObject",
            "Effect": "Allow",
            "Principal": "*",
            "Action": "s3:GetObject",
            "Resource": "arn:aws:s3:::run-log.bryanesmith.com/*"
        }
    ]
}
EOF

  website {
    index_document = "index.html"
  }
}
