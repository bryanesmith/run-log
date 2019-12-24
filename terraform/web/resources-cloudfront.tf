locals {
  s3_origin_id = "s3-${var.s3_bucket_web}"
}

resource "aws_cloudfront_distribution" "run-log-distribution" {
  enabled = true
  default_root_object = "index.html"
  is_ipv6_enabled = true
  tags = var.common_tags

  default_cache_behavior {
    allowed_methods  = ["DELETE", "GET", "HEAD", "OPTIONS", "PATCH", "POST", "PUT"]
    cached_methods   = ["GET", "HEAD"]
    target_origin_id = local.s3_origin_id
    viewer_protocol_policy = "redirect-to-https"

    forwarded_values {
      query_string = false
      headers      = ["Origin"]

      cookies {
        forward = "none"
      }
    }

  } # default_cache_behavior

  origin {
    domain_name = aws_s3_bucket.web-bucket.bucket_regional_domain_name
    origin_id = local.s3_origin_id
  }

  restrictions {
    geo_restriction {
      restriction_type = "none"
    }
  }

  viewer_certificate {
    cloudfront_default_certificate = true
  }
} # run-log-distribution
