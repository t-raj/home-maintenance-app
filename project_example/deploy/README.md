### DIRECTIONS

-	In /tmp folder
-	tar -xvzf deploy.tar.gz
-	cd deploy
-	./provisioner.sh

### Test ###

-	service flask_app status (should say active and green)
-	lynx localhost:5000 (you should see a home page and like a signup and all that)
