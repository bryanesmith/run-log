provider "aws" {
  region = var.aws_region
}

terraform {
  backend "s3" {
    # Must specify bucket, region via `terraform init` command-line params
    key    = "terraform/terraform.tfstate"
  }
}
