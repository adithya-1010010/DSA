git add .

#to read the message from the user
echo "Enter the commit message"
read msg

git commit -m"$msg"
git push origin main
