#!/bin/bash
EMAIL="$1"

echo "Instalando mailutils..."
sudo apt-get update -y
sudo apt-get install -y mailutils

echo "Pipeline executado!" | mail -s "Pipeline Info" "$EMAIL"
