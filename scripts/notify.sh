#!/bin/bash
sudo apt-get install mailutils -y
echo $EMAIL_DEST
echo "All tests have been executed correctly" | mail -s "Test results for Currency project" $EMAIL_DEST
