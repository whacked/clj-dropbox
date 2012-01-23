(ns clj-dropbox.constants)

(def ^:private +drbx-api-version+ 1)

(def ^:private +drbx-api+ (str "https://api.dropbox.com/" +drbx-api-version+ "/"))

(def +drbx-oauth-host+ (str "https://api.dropbox.com/" +drbx-api-version+ "/oauth/"))

(def +drbx-oauth-token+ (str +drbx-api+  "token"))

(def +drbx-files-host+  (str "https://api-content.dropbox.com/" +drbx-api-version+
			     "/files/dropbox/"))

(def +modes+ #{:sandbox :dropbox})

(defn drbx-files-host [mode]
  (cond (= mode :sandbox)
	(str "https://api-content.dropbox.com/" +drbx-api-version+ "/files/sandbox/")
	(= mode :dropbox)
	(str "https://api-content.dropbox.com/" +drbx-api-version+ "/files/dropbox/")
	:default
	(throw (IllegalArgumentException.
		(str "Bad mode: " mode " should be one of " +modes+)))))

(defn drbx-metadata-host [mode]
    (cond (= mode :sandbox)
	(str "https://api.dropbox.com/" +drbx-api-version+ "/metadata/sandbox/")
	(= mode :dropbox)
	(str "https://api.dropbox.com/" +drbx-api-version+ "/metadata/dropbox/")
	:default
	(throw (IllegalArgumentException.
		(str "Bad mode: " mode " should be one of " +modes+)))))

(def +drbx-copy-file+
  (str "https://api.dropbox.com/" +drbx-api-version+ "/fileops/copy"))

(def +drbx-move-file+
  (str "https://api.dropbox.com/" +drbx-api-version+ "/fileops/move"))

(def +drbx-create-folder+
  (str "https://api.dropbox.com/" +drbx-api-version+ "/fileops/create_folder"))

(def +drbx-delete+
  (str "https://api.dropbox.com/" +drbx-api-version+ "/fileops/delete"))
